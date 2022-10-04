class Conteudo {
  constructor() {
}

dadosUsuario(){
  let id = JSON.parse(localStorage.getItem("user"));
  //let nome = user._name;
  let user = new XMLHttpRequest();
  user.onload = function() {
    let objuser = JSON.parse(user.response);
    let userlog = new Usuario(objuser.id, objuser.name, objuser.email, objuser.phone, objuser.username, objuser.address, objuser.company);
    let tgName = document.querySelector(".userName");
    tgName.innerText = userlog.getName();
  }
  user.open("GET","https://jsonplaceholder.typicode.com/users/"+id);
  user.send();

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
ct.dadosUsuario();
