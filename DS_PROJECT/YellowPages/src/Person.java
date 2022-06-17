class Person {
    String name;
    Long phone_number;
    String email;
    String address;


    public Person(String n, Long num, String em, String add){
        name=n;
        phone_number=num;
        email=em;
        address=add;
    }

    Person() {  }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Long phone_number) {
        this.phone_number = phone_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAll(Person p){
        this.name=p.name;
        this.address=p.address;
        this.email=p.email;
        this.phone_number=p.phone_number;
    }
}
