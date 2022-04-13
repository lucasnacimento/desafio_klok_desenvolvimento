
import axios from "axios";
import './styles.css';
import React, { useEffect, useState } from "react";
import PainelFormulario from '../../components/PainelFormulario/index';
import { URL_BASE, URL_PRODUTO } from "../../config/request";
import { Produto } from "../../types/produto";

function Home() {

    const [listaProdutos, setListaProdutos] = useState<Produto[]>([]);

    useEffect(() =>{
        axios.get(`${URL_BASE}${URL_PRODUTO}`, { 'headers': { 'Authorization': `Bearer ${window.localStorage.getItem("token")}` } }
        )
            .then((response) => {
                const lista = response.data as Produto[];
                setListaProdutos(lista)
        });
    }, []);

        return (
            <div className="page-home">
                <div className="titulo-home">
                    <h1>Adesões de produtos</h1>
                </div>
                
                <PainelFormulario lista={listaProdutos}/>
            </div>
        );

}

export default Home;