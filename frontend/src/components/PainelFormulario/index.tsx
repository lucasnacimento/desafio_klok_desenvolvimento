import { useEffect, useState } from 'react';
import { ListaProduto, Produto } from '../../types/produto';

type Props = {
    lista: Produto[];
}

function identificarSelectCampos() {
    const selectCampos = document.querySelector("#lista-produtos")as HTMLSelectElement;
    const opcao = selectCampos.options[selectCampos.selectedIndex].value;
    return Number(opcao);
}

function PainelFormulario( { lista } : Props) {

    
    const [produto, setProduto] = useState<Produto | null>({
        id: 0,
        nome: "",
        descricao: "",
        preco: 0,
        listaCampos: []
    });
    
    console.log(produto);

    useEffect(() => {
        let listaProdutos: Produto[] = [];
        listaProdutos = lista.filter(p => p.id === identificarSelectCampos());
        setProduto(listaProdutos[0]);
    }, [produto]);

    return (
        <>
        <div className="painel-formulario">
            <select name='lista-produtos' id="lista-produtos" onChange={identificarSelectCampos}>
                {lista?.map(p => (
                    <option value={p.id}>{p.nome}</option>
                ))}
            </select>

            <div className="campos">
                {
                  /* lista?.filter(p => p.id === identificarSelectCampos()+1)
                        .map(c => c.listaCampos.map(i => (
                            <li>
                                <label htmlFor="">{i.nome}</label>
                                <input type="text" id={i.nome} />
                            </li>
                        ))) */
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