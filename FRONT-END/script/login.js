class Login{
    constructor(){

    }



    logar(){
      let form = document.querySelector(".form");
      form.addEventListener("submit",function(event) {
        event.preventDefault();
      });

      if(this.validaCampos()) {
        this.comparaCampos();
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

        var status = "procurando";

        usr.onload = function() {
          let logJson = JSON.parse(usr.response);

              for(let i = 0; i < logJson.length; i++){

                  //armazenando dados percorridos da array para comparação
                  let nomeJson = logJson[i].name;
                  let senhaJson = logJson[i].username;

                  //armazenando objeto da Array compatível no localStorage
                  if(nome == nomeJson && senha == senhaJson){

                      let usuario = new Usuario(logJson[i].id,logJson[i].name,logJson[i].email,logJson[i].phone,logJson[i].username,logJson[i].address,logJson[i].company);
                      localStorage.setItem("user", JSON.stringify(usuario.getId()));
                      status = "encontrado";
                      location.href = "usuario.html";
                  }
                  if(this.status == "encontrado") {

                      i = logJson.length;
                  }
                  if(i == logJson.length - 1 && status != "encontrado") {
                      window.alert("nenhum usuário encontrado");

                  }
              }
        }

        usr.open("GET","https://jsonplaceholder.typicode.com/todos/1/users");

        usr.send();

    }



}
let ul = new Login();
