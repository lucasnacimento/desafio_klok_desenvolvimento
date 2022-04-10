import { Produto } from '../../types/produto';

type Props = {
    produto: Produto;
}

function PainelFormulario( {produto} : Props) {
    return (
        <div className="painel-formulario">
            <ul>
                <select id="cars">
                    <option value="volvo">Volvo</option>
                    <option value="saab">Saab</option>
                    <option value="opel">Opel</option>
                    <option value="audi">Audi</option>
                </select>
            </ul>

            <ul>
                <li>
                    <label htmlFor="campo">Campo</label>
                    <input type="text" id="campo" />
                </li>
                <li>
                    <label htmlFor="campo">Campo</label>
                    <input type="text" id="campo" />
                </li>
                <li>
                    <label htmlFor="campo">Campo</label>
                    <input type="text" id="campo" />
                </li>
                <li>
                    <label htmlFor="campo">Campo</label>
                    <input type="text" id="campo" />
                </li>
            </ul>

            <button type="submit">Salvar</button>
        </div>
    )
}

export default PainelFormulario;