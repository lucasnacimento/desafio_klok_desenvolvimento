import PainelFormulario  from '../../components/PainelFormulario/index';

import { useEffect, useState } from "react";
import { Produto } from "../../types/produto";
import axios from "axios";
import { URL_PRODUTO }  from "../../config/request";
import { URL_BASE }  from "../../config/request";

function Home() {

    const [produto, setProduto] = useState<Produto>({
        id: 1,
        nome: ""
    });

    useEffect(() => {
        axios.get(`${URL_BASE}${URL_PRODUTO}`)
             .then((response) => {
                 const data = response.data as Produto;
                 console.log(data);
                 setProduto(data);
             });
    }, [produto]);


    return (
        <h1>Olá mundo</h1>
    );
}

export default Home;