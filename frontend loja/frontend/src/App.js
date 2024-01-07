import logo from './logo.svg';
import './App.css';
import FormProduto from './pages/produto';
import TabelaProduto from './pages/table-produto';
import { Button, Form } from 'antd';

function App() {
  return (
    <>
      <FormProduto />
      <TabelaProduto />

    </>
  );
}

export default App;
