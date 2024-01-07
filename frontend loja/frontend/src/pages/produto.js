import React, { useEffect, useState } from 'react';
import { saveProduto } from '../services/produto';
import {
  Button,
  Cascader,
  DatePicker,
  Form,
  Input,
  InputNumber,
  Radio,
  Select,
  Switch,
  TreeSelect,
} from 'antd';
const FormProduto = () => {
  const [componentSize, setComponentSize] = useState('default');
  const [produtos, saveProduto] = useState();

  const onFormLayoutChange = ({ size }) => {
    setComponentSize(size);
  };

  const cadastrar = (produto) => {
    const data = saveProduto(produto);
    return data;
  }
  
  return (
    <Form
      labelCol={{
        span: 4,
      }}
      wrapperCol={{
        span: 14,
      }}
      layout="horizontal"
      initialValues={{
        size: componentSize,
      }}
      onValuesChange={onFormLayoutChange}
      size={componentSize}
      style={{
        maxWidth: 600,
      }}
    >
      <Form.Item label="Nome">
        <Input />
      </Form.Item>
      <Form.Item label="Desrcicao">
        <Input />
      </Form.Item>

     
      <Form.Item label="Preco">
        <InputNumber />
      </Form.Item>

      <Form.Item>
        <Button onClick={cadastrar}>
          Cadastrar
        </Button>
      </Form.Item>
    </Form>
  );
};
export default FormProduto;