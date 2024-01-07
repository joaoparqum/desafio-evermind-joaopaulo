import React, { useEffect, useState } from 'react';
import { Table } from 'antd';
import { getProdutos } from '../services/produto';
import Column from 'antd/es/table/Column';

const TabelaProduto = () => {
    const [produtos, setProdutos] = useState();

    useEffect(() => {
        const data = getProdutos();
        setProdutos(data);
    })

    return <Table dataSource={produtos}>
            <Column title="Id" dataIndex="id" key="id" />
            <Column title="Nome" dataIndex="nome" key="nome" />
            <Column title="Descrição" dataIndex="descricao" key="descricao" />
            <Column title="Preço" dataIndex="preco" key="preco" />
        </Table>

};
export default TabelaProduto;