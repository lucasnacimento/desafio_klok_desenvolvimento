import { useEffect, useState } from 'react';
import { Produto } from '../../types/produto';

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

    const [selecionado, setSelecionado] = useState(0);
    
    useEffect(() => {
        let listaProdutos = lista.filter(p => p.id === selecionado);
        setSelecionado(identificarSelectCampos);
        setProduto(listaProdutos[0]);
    }, [selecionado, produto, lista]);

    return (
        <>
        <div className="painel-formulario">
            <select name='lista-produtos' id="lista-produtos" value={selecionado} onChange={texto => setSelecionado(Number(texto.target.value))}>
                {lista.map(p => (
                    <option value={p.id}>{p.nome}</option>
                ))}
            </select>

            <div className="campos">
                {
                    produto?.listaCampos.map(c => (
                        <li>
                            <label htmlFor="">{c.nome}</label>
                            <input type="text" id={c.nome} />
                        </li>
                    ))

                }
            </div>

            <button type="submit">Salvar</button>
        </div>
        </>
    )
}

export default PainelFormulario;