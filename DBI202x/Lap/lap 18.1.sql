create database lap18;
use lap18;
create table employee(
	employee_id int auto_increment primary key,
    name varchar(150),
    address varchar(200),
    birthday datetime,
    position varchar(150),
    age varchar(3)
);

create table department(
	department_id int auto_increment primary key,
    department_name varchar(150)
);

create table projects(
	project_id int auto_increment primary key,
    project_name varchar(150)
);

create table works(
	department_id int not null,
    employee_id int not null,
    foreign key (department_id) references department(department_id),
    foreign key (employee_id) references employee(employee_id)
);

create table participations(
    employee_id int not null,
	project_id int not null,
    foreign key (project_id) references projects(project_id),
    foreign key (employee_id) references employee(employee_id)
);


create table students(
	student_id int auto_increment primary key,
    student_name varchar(150),
    address varchar(200),
    birthday datetime
);

create table class(
	class_id int auto_increment primary key,
    class_name varchar(150)
);

create table subjects(
	subject_id int auto_increment primary key,
    subjtect_name varchar(150)
);

create table enrollment(
	student_id int not null,
    subject_id int not null,
    foreign key (student_id) references students(student_id),
    foreign key (subject_id) references subjects(subject_id)
);

create table Study(
    class_id int not null,
	subject_id int not null,
    foreign key (class_id) references class(class_id),
    foreign key (subject_id) references subjects(subject_id)
);

create table study_result(
    class_id int not null,
	student_id int not null,
    point float,
    status varchar(50),
    foreign key (class_id) references class(class_id),
    foreign key (student_id) references students(student_id)
);


