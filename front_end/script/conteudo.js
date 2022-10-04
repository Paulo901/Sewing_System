class Conteudo {
  constructor() {
}

nomeUsuario(){
  let user = JSON.parse(localStorage.getItem("user"));
  let nome = user._name;

  let tgName = document.querySelector(".userName");
  tgName.innerText = nome;
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
ct.nomeUsuario();
