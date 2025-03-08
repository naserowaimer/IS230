# IS230 Tutorial – Project Part I
ER design and implementation
## Project introduction
### Student
**Name:** Nasser Alowaymir

**ID:** 445102817
### Project introduction
This project is for making a ERD, relational model, and export it as sql commands according to the requirments given below.
### Project requirments


<br/>

> [!WARNING]
> تنبيهات مهمة لا يعذر الطالب بعدم أخذها بعين الاعتبار مهما كان السبب:
> 1.	أي تشابه في المشاريع, و لو جزئي, يعرض الطالب لرصد صفر كدرجة للمشروع و تقرير لدكتور المادة مع إمكانية رفع التقرير لرئيس القسم.
> 2.	يتم تسليم تقرير المشروع على الـ Blackboard.
>  -	المشاريع المسلمة عن طريق البريد أو البريد الإلكتروني لن تقبل.
>3.	عدم التقيد بمتطلبات التقرير (المذكورة في قالب تقرير المشروع (Project Report Template)) سوف يعرض الطالب لخصم درجات.



</br>

---
#### Project describtion

The KSU Helpdesk Unit needs to design a database to follow up on technical support provided to its users (employees, faculties, students, etc.) facing any kind of problems during their work. The following information is needed to keep track of users: the username (identifier), their full-name, a mobile number, and their affiliation.<mark>Affiliation consists</mark>[^1] of: the college and the department to which the user is affiliated. To request help from the unit, a user may open **one or several** tickets. A ticket is uniquely described by a ticket ID and needs to record the opening date. A ticket is opened by **one and only one** *user*. Afterwards a ticket is resolved by <mark>**one** *Fix* **or many**</mark>[^2] Fixes. A Fix number uniquely identifies a Fix; and a Fix also has a Fix designation and a <mark>**ticket total** number</mark>[^3] (representing the number of tickets resolved by that Fix). A Fix may resolve **one or more** *tickets*. The database also stores the technicians who work at the help desk. Each technician is defined by their employee ID and we also record their email addresses, which might be **more than one**. A technician may work **on one or more** *Fixes*; a Fix must have **at least one** technician working on it. Note that each technician may leave a comment on a Fix they worked on. A <mark>Fix may have prerequisites</mark>[^4] (i.e. it requires other Fixes to be finished first). <mark>Finally, at the closure of a ticket, a ticket rating is conducted. A ticket rating has a category and is identified by a rating ID, though a ticket may have any number of ratings, the **rating ID always starts from 1 for each ticket**.</mark>[^5]

<br/>

---
**ERD Notes**
[^1]: I assumed that it is jus a composite attribute, since is hasn’t any relations to other entities, and can vary between users.

[^2]: Since a ticket may hasn’t been solved yet, so it could exist without a Fix made for it. Then I am going to make it optional.

[^3]: I made it Derived, since it came from the relation between Fix and Ticket

[^4]: Single fix is prerequest 0 or multiple fixs, and a fix is prerequested for multiple fix.
  This makes a many to many relation, with fix that prerequests another fixs means 2 fixs must choosen, but when no prerequest wanted then no any fixs choosen in this relation. I have no idea how to implement this in ERD, so I made it very detailed with text in the diagram.
[^5]: Since the rating is only identified using its ID (which may repeat through multiple tickets) with the ticket ID associated with it; then it will be a weak entity. and since a ticket can have many rating, I assumed it can also have no rating if the user didn’t added the rating. and a rating must be assosiated with a single ticket since it is weak entity. then: the relation will be one and only one ticket has zero or may ratings.

#### Project instructions
1. Use the report template to submit the group’s work and complete each of the required sections carefully to not lose marks. 
  -	Section#1 is the ER resulting from the above project statement. you can draw it by hand or use any drawing software (SUGGESTION: use https://erdplus.com/)
  - Section#2 is to adapt the resulting ER from section#1 to be drawn using MySQL Workbench.
  - Section#3 is exporting the SQL script to generate a database.
2. Use the MySQL Workbench tool to draw the requested ER diagram in Section#2 taking into account the following:
  a)	Choose a convenient domain for each attribute (like INT for integers, FLOAT for fractions or VARCHAR for strings).
  b)	Specify key attributes for each entity type as well as cardinality ratio and participation constraints for each relationship type.
3. The group report should be uploaded to the blackboard by the group leader ONLY.

## Project Implementaion

Here I am impelenting my database design according to the requirements.

### 1. ER
