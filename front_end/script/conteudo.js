class Conteudo {
  constructor() {
    this.userDatas();
}

userDatas(){


  let id = JSON.parse(localStorage.getItem("user"));

  let user = new XMLHttpRequest();
  user.onload = function() {

    let objuser = JSON.parse(user.response);
    let userlog = new Usuario(objuser.id, objuser.name, objuser.email, objuser.phone, objuser.username, objuser.address, objuser.company);

    ct.userName(userlog.getUsername());
    ct.historico(userlog.getCompany());
  }
  user.open("GET","https://jsonplaceholder.typicode.com/users/"+id);
  user.send();

}

userName(name){
  let tgName = document.querySelector("#nomeUsuario");
  tgName.innerText = name;
}

historico(historico){

    let tbody = document.querySelector('#tbody');

    //for(let i = 0; i < historico.length; i++){

        let linha = tbody.insertRow();

        let dta = linha.insertCell();
        let items = linha.insertCell();
        let valor = linha.insertCell();

        dta.innerText = historico.bs;
        items.innerText = historico.catchPhrase;
        valor.innerText = historico.name;
    //}
}
produtos(){
  this.populares();
  this.novos();
  this.destaques();
}

populares(){

  let mv = new XMLHttpRequest();

  mv.onload = function() {

    let produtos = JSON.parse(mv.response);

    for(let i = 0; i < 10; i++){

      //abaixo conteúdo dinâmico
      let item = document.createElement("div");
      item.className = "item";

      let img = document.createElement("img");
      let info = document.createElement("p");
      let valor = document.createElement("span");

      img.className = "imagem_item";
      info.className = "info";
      valor.className = "valor";

      //inserindo valores JSON
      img.src = produtos[i].url ;
      info.innerText = produtos[i].title ;
      valor.innerText = "R$ " + produtos[i].id + "0,00";
      //inserindo valores JSON

      item.appendChild(img);
      item.appendChild(info);
      item.appendChild(valor);

      let populares = document.querySelector(".itens_populares");

      populares.appendChild(item);

      //acima conteúdo dinâmico
    }
  }

  mv.open("GET","https://jsonplaceholder.typicode.com/todos/1/photos");

  mv.send();

 }

novos(){

   let mv = new XMLHttpRequest();

   mv.onload = function() {

     let produtos = JSON.parse(mv.response);

     for(let i = 0; i < 10; i++){

       //abaixo conteúdo dinâmico
       let item = document.createElement("div");
       item.className = "item";

       let img = document.createElement("img");
       let info = document.createElement("p");
       let valor = document.createElement("span");

       img.className = "imagem_item";
       info.className = "info";
       valor.className = "valor";

       //inserindo valores JSON
       img.src = produtos[i].url ;
       info.innerText = produtos[i].title ;
       valor.innerText = "R$ " + produtos[i].id + "0,00";
       //inserindo valores JSON

       item.appendChild(img);
       item.appendChild(info);
       item.appendChild(valor);

       let novos = document.querySelector(".itens_novos");

       novos.appendChild(item);

       //acima conteúdo dinâmico
     }
   }

   mv.open("GET","https://jsonplaceholder.typicode.com/todos/1/photos");

   mv.send();

  }

destaques(){

    let mv = new XMLHttpRequest();

    mv.onload = function() {

      let produtos = JSON.parse(mv.response);

      for(let i = 0; i < 10; i++){

        //abaixo conteúdo dinâmico
        let item = document.createElement("div");
        item.className = "item";

        let img = document.createElement("img");
        let info = document.createElement("p");
        let valor = document.createElement("span");

        img.className = "imagem_item";
        info.className = "info";
        valor.className = "valor";

        //inserindo valores JSON
        img.src = produtos[i].url ;
        info.innerText = produtos[i].title ;
        valor.innerText = "R$ " + produtos[i].id + "0,00";
        //inserindo valores JSON

        item.appendChild(img);
        item.appendChild(info);
        item.appendChild(valor);

        let destaques = document.querySelector(".itens_destaques");

        destaques.appendChild(item);

        //acima conteúdo dinâmico
      }
    }

    mv.open("GET","https://jsonplaceholder.typicode.com/todos/1/photos");

    mv.send();

   }
}

let ct = new Conteudo();
ct.produtos();
