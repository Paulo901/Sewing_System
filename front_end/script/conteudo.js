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
    console.log(userlog.getCompany());
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

maisVendidos(){

  let mv = new XMLHttpRequest();

  mv.onload = function() {

    let itens = JSON.parse(usr.response);

    for(let i = 0; i < itens.length; i++){

      //abaixo conteúdo dinâmico
      const card = document.createElement("div");
      card.id = "card";

      const img = document.createElement("div");
      const descricao = document.createElement("p");
      const valor = document.createElement("cite");

      //inserindo valores JSON
      img.innerText = itens[i].id ;
      descricao.innerText = itens[i].title ;
      valor.innerText = itens[i].url ;
      //inserindo valores JSON

      card.appendChild(img);
      card.appendChild(descricao);
      card.appendChild(valor);

      const main = document.getElementById("vendidos");

      main.appendChild(card);
      //acima conteúdo dinâmico
    }
  }

  mv.open("GET","https://jsonplaceholder.typicode.com/todos/1/photos");

  mv.send();

 }
}

let ct = new Conteudo();
