ALTER TABLE DIRECTS
   ADD manager_id int NOT NULL;

ALTER TABLE DIRECTS
  ADD FOREIGN KEY (manager_id) REFERENCES MANAGERS(id);