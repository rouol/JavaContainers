package com.mephi.rouol.AccountantBot;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Objects;

import com.ibm.icu.text.Transliterator;

public class Employee {

    public enum Gender {
        MALE, FEMALE;
        @Override
        public String toString() {
            return (this.equals(Gender.MALE) ? "Мужчина" :
                    this.equals(Gender.FEMALE) ? "Женщина" : "");
        }
    }
    public enum Role {
        STAFF(100000, 0.1),
        MANAGER(150000, 0.2),
        EXECUTIVE(250000, 0.3);

        private final int salary;
        private final double premium;

        public int getSalary() {
            return salary;
        }

        public double getPremium() {
            return premium;
        }

        Role(int salary, double premium) {
            this.salary = salary;
            this.premium = premium;
        }

        @Override
        public String toString() {
            return (this.equals(Role.EXECUTIVE) ? "Руководитель" :
                    this.equals(Role.MANAGER) ? "Менеджер" :
                    this.equals(Role.STAFF) ? "Сотрудник" : "");
        }
    }
    public enum Dept {
        HUMAN_RESOURCES, MARKETING, SALES, FINANCE, LOGISTICS, IT, PURCHASING, RESEARCH_AND_DEVELOPMENT;

        @Override
        public String toString() {
            return (this.equals(Dept.IT) ? "IT" :
                    this.equals(Dept.FINANCE) ? "Финансов" :
                    this.equals(Dept.HUMAN_RESOURCES) ? "Кадров" :
                    this.equals(Dept.LOGISTICS) ? "Логистики" :
                    this.equals(Dept.MARKETING) ? "Маркетинга" :
                    this.equals(Dept.PURCHASING) ? "Закупок" :
                    this.equals(Dept.RESEARCH_AND_DEVELOPMENT) ? "Исследования и развития" :
                    this.equals(Dept.SALES) ? "Продаж" : "");
        }
    }

    private String givenName, surName;
    private int age;
    private Gender gender;
    private Role role;
    private Dept dept;
    private String eMail, phone, address, city, state;
    private int code;

    public Employee(String givenName, String surName, int age, Gender gender, Role role, Dept dept, String eMail, String phone, String address, String city, String state, int code) {
        this.givenName = givenName;
        this.surName = surName;
        this.age = age;
        this.gender = gender;
        this.role = role;
        this.dept = dept;
        this.eMail = eMail;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.code = code;
    }

    private static class EmployeeBuilder {
        private String givenName;
        private String surName;
        private int age;
        private Employee.Gender gender;
        private Employee.Role role;
        private Employee.Dept dept;
        private String eMail;
        private String phone;
        private String address;
        private String city;
        private String state;
        private int code;

        public void setGivenName(String givenName) {
            this.givenName = givenName;
        }

        public void setSurName(String surName) {
            this.surName = surName;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }

        public void setRole(Role role) {
            this.role = role;
        }

        public void setDept(Dept dept) {
            this.dept = dept;
        }

        public void seteMail(String eMail) {
            this.eMail = eMail;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setState(String state) {
            this.state = state;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public Employee createEmployee() {
            return new Employee(givenName, surName, age, gender, role, dept, eMail, phone, address, city, state, code);
        }
    }

    // getters/setters

    public String getGivenName() {
        return givenName;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Role getRole() {
        return role;
    }

    public Dept getDept() {
        return dept;
    }

    public String geteMail() {
        return eMail;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "givenName='" + givenName + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", role='" + role + '\'' +
                ", dept='" + dept + '\'' +
                ", eMail='" + eMail + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && code == employee.code && givenName.equals(employee.givenName) && surName.equals(employee.surName) && gender == employee.gender && role == employee.role && dept.equals(employee.dept) && eMail.equals(employee.eMail) && phone.equals(employee.phone) && address.equals(employee.address) && city.equals(employee.city) && state.equals(employee.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(givenName, surName, age, gender, role, dept, eMail, phone, address, city, state, code);
    }

    /** returns an Employee instance with specified dept and role **/
    public static Employee generateEmployee(Dept dept, Role role){

        EmployeeBuilder builder = new EmployeeBuilder();

        SecureRandom randomNumber = new SecureRandom();
        final String CYRILLIC_TO_LATIN = "Russian-Latin/BGN";
        Transliterator toLatinTrans = Transliterator.getInstance(CYRILLIC_TO_LATIN);

        builder.setDept(dept);
        builder.setRole(role);

        String givenName, surName;

        switch ((Gender) randomChoice(Gender.values())){
            case MALE: {
                builder.setGender(Gender.MALE);
                builder.setAge(minEmployeeAge + randomNumber.nextInt(maxMaleEmployeeAge - minEmployeeAge));
                givenName = (String) randomChoice(maleNames);
                surName = (String) randomChoice(maleSurNames);
                break;
            }
            case FEMALE: {
                builder.setGender(Gender.FEMALE);
                builder.setAge(minEmployeeAge + randomNumber.nextInt(maxFemaleEmployeeAge - minEmployeeAge));
                givenName = (String) randomChoice(femaleNames);
                surName = (String) randomChoice(femaleSurNames);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + (Gender) randomChoice(Gender.values()));
        }
        builder.setGivenName(givenName);
        builder.setSurName(surName);
        String eMail = toLatinTrans.transliterate(givenName.charAt(0) + surName) + "@yandex.ru";
        builder.seteMail(eMail);
        String phone = "+7" + randomChoice(phoneCodes)
                + randomNumber.nextInt(10)
                + randomNumber.nextInt(10)
                + randomNumber.nextInt(10)
                + randomNumber.nextInt(10)
                + randomNumber.nextInt(10)
                + randomNumber.nextInt(10)
                + randomNumber.nextInt(10);
        builder.setPhone(phone);
        int code = randomNumber.nextInt(states.length);
        builder.setCode(code);
        builder.setState(states[code]);
        builder.setCity(cities[code]);
        String address = randomChoice(streets) + ", " + randomNumber.nextInt(50);
        builder.setAddress(address);

        return builder.createEmployee();
    }

    /** returns an arbitrary Employee instance **/
    public static Employee generateEmployee(){
        return generateEmployee((Dept) randomChoice(Dept.values()), (Role) randomChoice(Role.values()));
    }

    /** returns an ArrayList of Employee instances **/
    public static ArrayList<Employee> createShortList() {
        ArrayList<Employee> employees = new ArrayList<>();
        SecureRandom randomNumber = new SecureRandom();

        for (Dept _dept : Dept.values()){
            // make 1 EXECUTIVE
            employees.add(generateEmployee(_dept, Role.EXECUTIVE));
            // make 1 MANAGER
            employees.add(generateEmployee(_dept, Role.MANAGER));
            // make random STAFF
            for (int i = 0; i < randomNumber.nextInt(10); i++){
                employees.add(generateEmployee(_dept, Role.STAFF));
            }
        }

        return employees;
    }

    private static Object randomChoice(Object[] arrayList){
        SecureRandom randomNumber = new SecureRandom();
        return arrayList[randomNumber.nextInt(arrayList.length)];
    }

    // data for Employee generation
    private static final String[] maleNames = {"Артём", "Александр", "Максим", "Даниил",
            "Дмитрий", "Иван", "Кирилл", "Никита", "Михаил", "Егор",
            "Матвей", "Андрей", "Илья", "Алексей", "Роман", "Сергей",
            "Владислав", "Ярослав", "Тимофей", "Арсений", "Денис",
            "Владимир", "Павел", "Глеб", "Константин", "Богдан", "Евгений",
            "Николай", "Степан", "Захар", "Тимур", "Марк", "Семён",
            "Фёдор", "Георгий", "Лев", "Антон", "Вадим", "Игорь", "Артур"};
    private static final String[] femaleNames = {"София", "Анастасия", "Дарья", "Мария", "Анна",
            "Виктория", "Полина", "Елизавета", "Екатерина", "Ксения",
            "Валерия", "Варвара", "Александра", "Вероника", "Арина",
            "Алиса", "Алина", "Милана", "Маргарита", "Диана", "Ульяна",
            "Алёна", "Ангелина", "Кристина", "Юлия", "Кира", "Ева",
            "Карина", "Василиса", "Ольга", "Ирина", "Таисия", "Евгения"};
    private static final String[] maleSurNames = {"Иванов", "Васильев", "Петров", "Смирнов",
            "Михайлов", "Фёдоров", "Соколов", "Яковлев", "Попов",
            "Андреев", "Алексеев", "Алекса  ндров", "Лебедев", "Григорьев",
            "Степанов", "Семёнов", "Павлов", "Богданов", "Николаев",
            "Дмитриев", "Егоров", "Волков", "Кузнецов", "Никитин",
            "Соловьёв", "Тимофеев", "Орлов", "Афанасьев", "Филиппов",
            "Сергеев", "Захаров", "Матвеев", "Виноградов", "Кузьмин",
            "Максимов", "Козлов", "Ильин", "Герасимов", "Марков",
            "Новиков", "Морозов", "Романов", "Осипов", "Макаров", "Зайцев",
            "Беляев", "Гаврилов", "Антонов", "Ефимов", "Леонтьев",
            "Давыдов", "Гусев", "Данилов", "Киселёв", "Сорокин",
            "Тихомиров", "Крылов", "Никифоров", "Кондратьев", "Кудрявцев",
            "Борисов", "Жуков", "Воробьёв", "Щербаков", "Поляков",
            "Савельев", "Шмидт", "Трофимов", "Чистяков", "Баранов",
            "Сидоров", "Соболев", "Карпов", "Белов", "Миллер", "Титов",
            "Львов", "Фролов", "Игнатьев", "Комаров", "Прокофьев", "Быков",
            "Абрамов", "Голубев", "Пономарёв", "Покровский", "Мартынов",
            "Кириллов", "Шульц", "Миронов", "Фомин", "Власов", "Троицкий",
            "Федотов", "Назаров", "Ушаков", "Денисов", "Константинов",
            "Воронин", "Наумов"};
    private static final String[] femaleSurNames = {"Иванова", "Васильева", "Петрова", "Смирнова",
            "Михайлова", "Фёдорова", "Соколова", "Яковлева", "Попова",
            "Андреева", "Алексеева", "Александрова", "Лебедева", "Григорьева",
            "Степанова", "Семёнова", "Павлова", "Богданова", "Николаева",
            "Дмитриева", "Егорова", "Волкова", "Кузнецова", "Никитина",
            "Соловьёва", "Тимофеева", "Орлова", "Афанасьева", "Филиппова",
            "Сергеева", "Захарова", "Матвеева", "Виноградова", "Кузьмина",
            "Максимова", "Козлова", "Ильина", "Герасимова", "Маркова",
            "Новикова", "Морозова", "Романова", "Осипова", "Макарова", "Зайцева",
            "Беляева", "Гаврилова", "Антонова", "Ефимова", "Леонтьева",
            "Давыдова", "Гусева", "Данилова", "Киселёва", "Сорокина",
            "Тихомирова", "Крылова", "Никифорова", "Кондратьева", "Кудрявцева",
            "Борисова", "Жукова", "Воробьёва", "Щербакова", "Полякова",
            "Савельева", "Шмидт", "Трофимова", "Чистякова", "Баранова",
            "Сидорова", "Соболева", "Карпова", "Белова", "Миллер", "Титова",
            "Львова", "Фролова", "Игнатьева", "Комарова", "Прокофьева", "Быкова",
            "Абрамова", "Голубева", "Пономарёва", "Покровская", "Мартынова",
            "Кириллова", "Шульц", "Миронова", "Фомина", "Власова", "Троицкая",
            "Федотова", "Назарова", "Ушакова", "Денисова", "Константинова",
            "Воронина", "Наумова"};
    private static final int minEmployeeAge = 18;
    private static final int maxFemaleEmployeeAge = 56;
    private static final int maxMaleEmployeeAge = 61;
    private static final String[] states = {"Амурская область", "Архангельская область",
            "Астраханская область", "Белгородская область",
            "Брянская область", "Владимирская область",
            "Волгоградская область", "Вологодская область",
            "Воронежская область", "Ивановская область",
            "Иркутская область", "Калининградская область",
            "Калужская область", "Камчатская область",
            "Кемеровская область", "Кировская область",
            "Костромская область", "Курганская область",
            "Курская область", "Ленинградская область",
            "Липецкая область", "Магаданская область",
            "Московская область", "Мурманская область",
            "Нижегородская область", "Новгородская область",
            "Новосибирская область", "Омская область",
            "Оренбургская область", "Орловская область",
            "Пензенская область", "Пермская область", "Псковская область",
            "Ростовская область", "Рязанская область", "Самарская область",
            "Саратовская область", "Сахалинская область",
            "Свердловская область", "Смоленская область",
            "Тамбовская область", "Тверская область", "Томская область",
            "Тульская область", "Тюменская область", "Ульяновская область",
            "Челябинская область", "Читинская область",
            "Ярославская область"};
    private static final String[] cities = {"Благовещенск", "Архангельск", "Астрахань", "Белгород", "Брянск", "Владимир", "Волгоград",
            "Вологда", "Воронеж", "Иваново", "Иркутск", "Калининград", "Калуга", "Петропавловск-Камчатский",
            "Кемерово", "Киров", "Кострома", "Курган", "Курск", "Гатчина", "Липецк", "Магадан", "Красногорск",
            "Мурманск", "Нижний Новгород", "Великий Новгород", "Новосибирск", "Омск", "Оренбург", "Орёл",
            "Пенза", "Пермь", "Псков", "Ростов", "Рязань", "Самара", "Саратов", "Южно-Сахалинск", "Екатеринбург",
            "Смоленск", "Тамбов", "Тверь", "Томск", "Тула", "Тюмень", "Ульяновск", "Челябинск", "Чита", "Ярославль"};
    private static final String[] streets = {"ул. Чехова", "пер. Ломоносова", "ул. Ленина", "ул. Космонавтов", "ул. Садовая",
            "ул. Лесная", "ул. Центральная", "пер. Зеленый", "ул. Партизанская"
    };
    private static final String[] phoneCodes = {"903", "909", "963", "964", "965", "966", "967",
            "968", "989", "929", "900", "901", "902", "908", "953", "958"};

}
