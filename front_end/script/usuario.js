class Usuario {
  constructor(id, name, email, phone, username, address, company) {
    this._id = id;
    this._name = name;
    this._email = email;
    this._phone = phone;
    this._username = username;
    this._address = address;
    this._company = company;
  }

  getId(){return this._id;}
  getName(){return this._name;}
  getEmail(){return this._email;}
  getPhone(){return this._phone;}
  getUsername(){return this._username;}
  getAddress(){return this._address;}
  getCompany(){return this._company;}
}
