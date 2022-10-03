class Login{
    constructor(){


    }



    logar(){
        if(this.validaCampos()) {
            if(this.comparaCampos()) {
              //window.location.href = "usuario.html";
              window.alert("deu certo");
            }
        }
    }
    validaCampos(){

        let email = document.querySelector(".name");
        let senha = document.querySelector(".password");

        let ms = "Informe ";

        if(email.value == "") {
            email.style.outline ="red 1px solid";
            ms += "seu email.";
        }
        if(senha.value == "") {
            senha.style.outline = "red 1px solid";
            ms += "sua senha.";
        }if(ms != "Informe ") {
            window.alert(ms);
            return false;
        }else{
            return true;
        }
    }
    comparaCampos(){

        //dados obtidos dos campos
        let nome = document.querySelector(".name").value;
        let senha = document.querySelector(".password").value;

        //convertendo JSON com array
        let usr = new XMLHttpRequest();

        usr.onload = function() {
          let logJson = JSON.parse(usr.response);
          console.log(usr);
              for(let i = 0; i < logJson.length; i++){

                  //armazenando dados percorridos da array para comparação
                  let nomeJson = logJson[i].name;
                  let senhaJson = logJson[i].username;

                  let status = "procurando";

                  //armazenando objeto da Array compatível no localStorage
                  if(nome == nomeJson && senha == senhaJson){

                      let usuario = new Usuario(logJson[i].id,logJson[i].name,logJson[i].email,logJson[i].phone,logJson[i].username,logJson[i].address,logJson[i].company);
                      localStorage.setItem("user", JSON.stringify(usuario));
                      status = "encontrado";
                      return true;
                  }
                  if(status == "encontrado") {

                      i = logJson.length;
                  }
                  if(i == logJson.length - 1 && status != "encontrado") {
                      window.alert("nenhum usuário encontrado");
                      return false;
                  }
              }
        }

        usr.open("GET","https://jsonplaceholder.typicode.com/todos/1/users");

        usr.send();


    }

    historico(historico){

        let tbody = document.getElementById('tbody');

        for(let i = 0; i < historico.length; i++){

            let linha = tbody.insertRow();

            let dta = linha.insertCell();
            let items = linha.insertCell();
            let valor = linha.insertCell();

            dta.innerText = historico[i].quantidade;
            items.innerText = historico[i].item;
            valor.innerText = historico[i].valor;
        }
    }



}
let ul = new Login();
