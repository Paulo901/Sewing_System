class UserLog {
  constructor() {

  }
  menu(action){
    let menu = document.querySelector(".menu");
    let menUser = document.querySelector(".menu_user");

    let btop = document.querySelector(".menu_op");

    if (action == "open") {
      btop.style.display = "none";

      menu.style.display = "flex";
      menUser.style.display = "flex";
    }
    if (action == "close") {
      btop.style.display = "block";

      menu.style.display = "none";
      menUser.style.display = "none";
    }
  }
}

let ul = new UserLog();
