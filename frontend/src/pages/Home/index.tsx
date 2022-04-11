import PainelFormulario  from '../../components/PainelFormulario/index';

import { useEffect, useState } from "react";
import { ListaProduto, Produto } from "../../types/produto";
import axios from "axios";
import { URL_PRODUTO }  from "../../config/request";
import { URL_BASE }  from "../../config/request";

function Home() {

    let listaProdutos: Produto[] = [];  

    const retorno = () => {
        return (
            <>
                <div className="titulo-home">
                    <h1>Adesões de produtos</h1>
                </div>
                <PainelFormulario lista={listaProdutos}/>
            </>
        );
    }

    
    useEffect(() => {
        axios.get(`${URL_BASE}${URL_PRODUTO}`)
             .then((response) => {
                 listaProdutos = response.data as Produto[];
                 console.log(listaProdutos);
                 retorno();
             });
    }, [listaProdutos]);

    return (
        <>
            {retorno()}
        </>

);
}

export default Home;