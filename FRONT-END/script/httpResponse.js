class httpMetodos {
  construtor(){

  }

  cadastro(){
    let cdt = new XMLHttpRequest();

    cdt.onload = function() {

      let respjson = JSON.parse(cdt.response);
      //usuario(respjson.todoId);
      console.log(respjson);
    }

    cdt.open("POST","https://jsonplaceholder.typicode.com/todos/1/users");

    let obj = {
      nome: "Luiz",
      senha: 123
    }

    let objson = JSON.stringify(obj);

    cdt.setRequestHeader("Content-type", "application/json");
    cdt.send(objson);

  }

  usuario(){
    let usr = new XMLHttpRequest();

    usr.onload = function() {
      let getobj = JSON.parse(usr.response);

      console.log(getobj);
      console.log(usr);
    }

    usr.open("GET","https://jsonplaceholder.typicode.com/todos/1/users");

    usr.send();
  }

}
let mt = new httpMetodos();
//mt.cadastro();
mt.usuario();
