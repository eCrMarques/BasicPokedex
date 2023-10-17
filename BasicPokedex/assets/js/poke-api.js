

const PokeApi = {}
// Teste
PokeApi.getDetail = (nDex) => {
    const url = `https://pokeapi.co/api/v2/pokemon/${nDex}`
    return fetch(url)
        .then((response) =>response.json())
        .then((jsonBody)=>jsonBody)
        .catch((error) => console.log(error))
}
// Teste
PokeApi.getPokemons = (offset =0 , limit = 10) => {
    const url = `https://pokeapi.co/api/v2/pokemon?offset=${offset}&limit=${limit}`
    return fetch(url)
        .then((response) =>response.json())
        .then((jsonBody)=>Promise.all(jsonBody.results))
        .catch((error) => console.log(error))
}
