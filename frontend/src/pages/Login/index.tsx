import axios from "axios";
import { useState } from "react";
import { URL_BASE, URL_LOGIN } from "../../config/request";
import { Credencias } from "../../types/produto";
import "./styles.css";
import { Link } from "react-router-dom";
function Login() {

  const [credencias] = useState<Credencias>({
    login: "",
    password: "",
  });

    function preencherCampos() {
        credencias.login = (document.getElementById("login") as  HTMLInputElement).value;
        credencias.password = (document.getElementById("password") as  HTMLInputElement).value;
    }
    function limparCampos() {
        credencias.login = "";
        credencias.password = "";
    }

  return (
    <div className="view-login">
      <div className="painel-login">
        <h1>Login</h1>
        <ul className="painel-campos">
          <li className="campo-item">
            <label htmlFor="nome">Login</label>
            <input id="login" type="text" />
          </li>
          <li className="campo-item">
            <label htmlFor="nome">Senha</label>
            <input id="password" type="password" />
          </li>
        </ul>
        <button type="submit" onClick={(e) => {
            preencherCampos();
            axios.post(`${URL_BASE}${URL_LOGIN}`, credencias)
            .then(response => {
                alert("Login com sucesso!");
                limparCampos(); 
                window.localStorage.setItem("token", response.data.mensagem);
                window.location.href = "/formulario";
            })
            .catch(response => {
                    console.log(response);
                 alert("Não autorizado!");
             })
        }}>Entrar</button>
      </div>
    </div>
  );
}

export default Login;
