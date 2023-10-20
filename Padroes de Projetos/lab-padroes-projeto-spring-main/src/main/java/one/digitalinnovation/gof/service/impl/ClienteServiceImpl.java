package one.digitalinnovation.gof.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.ClienteRepository;
import one.digitalinnovation.gof.model.Endereco;
import one.digitalinnovation.gof.model.EnderecoRepository;
import one.digitalinnovation.gof.service.ClienteService;
import one.digitalinnovation.gof.service.ViaCepService;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 * 
 * @author falvojr
 */
@Service
public class ClienteServiceImpl implements ClienteService {

	// Primeiro usar o @Autowired e criar variavel classe ClienteRepository
	@Autowired
	private ClienteRepository clienteRepository;

	// Linkar o EndereçoRepository para a Verificação da existencia do Cliente pelo CEP
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;


	@Override
	public Iterable<Cliente> buscarTodos() {
		//Segundo usar o metodo findAll da classe ClienteRepository 
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		//Utilizar os metodos da classe ClienteRepository
		//Optional ajuda no quesito da existencia ou Não
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Cliente cliente) {
		// Metodo salvar Através da pesquisa atraves do cep ou endereço e complementando um ao outro.
		salvarClienteComCep(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		// Utilização do salvar do mesmo metodo do inserir, atraves da falta de informação e utilização de endereço ou cep para complemento.
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent()) {
			salvarClienteComCep(cliente);
		}
	}

	@Override
	public void deletar(Long id) {

		clienteRepository.deleteById(id);
	}
// Metodo Organizado para limpar o codigo
	private void salvarClienteComCep(Cliente cliente) {
		// Nulidade do Cliente caso exista pelo CEP
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			// Caso a nulidade Buscar o endereço via metodo consultarcep
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			//Setar novo Endereço
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		//Atualizar Endereço Cliente
		cliente.setEndereco(endereco);
		clienteRepository.save(cliente);
	}

}
