import api from "../api/api"

const getProdutos = () => {
    const {data} =  api.get();
    return data;
}

const saveProduto = (produto) => {
    const {data} = api.post("/", produto);
    return data;
}

const deleteProduto = (produto) => {
    const {data} = api.delete("/", produto);
    return data;
}

const putProduto = (produto) => {
    const {data} = api.put("/", produto);
    return data;
}

export {
    getProdutos, saveProduto, putProduto, deleteProduto
}