let lim=0

function convertPokemonToHtml(pokemon,nDex=1,tipo='Ice',img=''){
    
    return `
        <li class="pokemon">
        <span class="number">#${nDex}</span>
        <span class="name">${(pokemon.name).charAt(0).toUpperCase()+pokemon.name.slice(1)}</span>

        <div class="detail">
            <ol class="types">
                ${tipo}
            </ol>

            <img src="${img}" 
            alt="${pokemon.name}">
        </div>               
    </li>
`
}

const pokemonList = document.getElementById('pokemonList')
PokeApi.getPokemons().then((pokemons)=> {
    for (let i =1; i<pokemons.length; i++){
        PokeApi.getDetail((i+1)).then((detail)=>{
            let tipo=''
            sprite=detail.sprites.other.dream_world.front_default
            for (let n=0;n<detail.types.length;n++){
                tipo+=`<li class="type ${(detail.types[n].type.name)}">${(detail.types[n].type.name).charAt(0).toUpperCase()+detail.types[n].type.name.slice(1)}</li>`
            }
            const pokemon = pokemons[i]
            pokemonList.innerHTML += convertPokemonToHtml(pokemon,(i+1),tipo,sprite)
        })
        
        
    }
})
PokeApi.Atualizar=(minNum,maxNum) =>{
    PokeApi.getPokemons(offset=minNum, limit=maxNum).then((pokemons)=> {
        for (let i =0; i<pokemons.length; i++){
            PokeApi.getDetail(pokemons[i].name).then((list)=>{
                let tipo=''
                sprite=list.sprites.other.dream_world.front_default
                for (let n=0;n<list.types.length;n++){
                    tipo+=`<li class="type ${(list.types[n].type.name)}">${(list.types[n].type.name).charAt(0).toUpperCase()+list.types[n].type.name.slice(1)}</li>`
                }
                const pokemon = pokemons[i]
                pokemonList.innerHTML += convertPokemonToHtml(pokemon,list.id,tipo,sprite)
            })
            
            
        }
    }) 
}
loadMoreButton.addEventListener('click', () => {
    lim+=10
    PokeApi.Atualizar(lim,10)
})