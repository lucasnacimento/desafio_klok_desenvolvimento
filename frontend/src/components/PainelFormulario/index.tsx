import { useEffect, useState } from 'react';
import './styles.css';
import { Produto, Adesao, Resposta, Campo } from '../../types/produto';
import axios from "axios";
import { URL_ADESAO, URL_BASE } from '../../config/request';

type Props = {
    lista: Produto[];
}

const identificarSelectCampos = () => {
    const selectCampos = document.querySelector("#lista-produtos")as HTMLSelectElement;
    let opcao = selectCampos.options[selectCampos.selectedIndex]?.value;
    return Number(opcao);
}

function PainelFormulario( { lista } : Props) {

    const [produto, setProduto] = useState<Produto>({
        id: 0,
        nome: "",
        descricao: "",
        preco: 0,
        listaCampos: []
    });

    const [novaAdesao, setNovaAdesao] = useState<Adesao>({
        idProdutoModel: 0,
        listaRespostas: []    
    });
    
    const [selecionado, setSelecionado] = useState(0);

    const [respostas, setRespostas] = useState<Resposta[]>([]);

    function preencherCampos() {
        produto.listaCampos.forEach((c) => {
            let campo:Campo = {
                nome: c.nome,
            };
            let resposta:Resposta = {
                campo: campo,
                valor: (document.getElementById(c.nome) as HTMLInputElement).value
            };
            respostas.push(resposta);
        })
        novaAdesao.idProdutoModel = selecionado;
        novaAdesao.listaRespostas = respostas;
    }

    
    useEffect(() => {
        let listaProdutos = lista.filter(p => p.id === selecionado);
        setSelecionado(identificarSelectCampos);
        setProduto(listaProdutos[0]);
    }, [selecionado, produto, lista]);

    return (
        <>
        <div className="painel-formulario">
            <h3>Produtos Disponíveis:</h3>
            <select name='lista-produtos' id="lista-produtos" value={selecionado} onChange={texto => setSelecionado(Number(texto.target.value))}>
                {lista.map(p => (
                    <option value={p.id}>{p.nome}</option>
                ))}
            </select>

                <div className="campos" id="campos">
                    {
                        produto?.listaCampos.map(c => (
                            <li className='campo-item'>
                                <label htmlFor="nome">{c.nome}</label>
                                <input type="text" id={c.nome}/>
                            </li>
                        ))

                    }
                </div>

            <button type="submit" onClick={(e) => {
                preencherCampos();
               axios.post(`${URL_BASE}${URL_ADESAO}`, novaAdesao)
               .then(response => {
                    console.log(response);
                })
                .catch(response => {
                    console.log(response);
                })
            }}>Salvar</button>
        </div>
        </>
    )
}

export default PainelFormulario;