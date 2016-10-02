import sqlite3
import os
import urllib

os.remove('./CSE/cse.db')
conn = sqlite3.connect('./CSE/cse.db')
print "Opened database successfully";

conn.execute('''CREATE TABLE cse
       (NAME          TEXT    NOT NULL,
       USERNAME		  TEXT	  PRIMARY KEY NOT NULL,
       EMAIL          TEXT    NOT NULL,
       EDUCATION      TEXT,
       PHONE		  TEXT,
       RESEARCH	      TEXT,
       IMAGE		  TEXT);''')
print "Table created successfully";

conn.close()

fo = open("cse.txt")
while fo.read(1) != '':
	fo.seek(-1,1)
	image = 'www.iitk.ac.in'
	while fo.read(1) != '\n':
		fo.seek(-1,1)
		image += fo.read(1)

	name=''
	while fo.read(1) != '\n':
		fo.seek(-1,1)
		name += fo.read(1)

	email=''
	while fo.read(1) != '\n':
		fo.seek(-1,1)
		email += fo.read(1)

	edu=''
	while fo.read(1) != '\n':
		fo.seek(-1,1)
		edu += fo.read(1)

	phone = 'Phone: '
	while fo.read(1) != '\n':
		fo.seek(-1,1)
		phone += fo.read(1)

	research = 'Research Interests: '
	while fo.read(1) != '\n':
		fo.seek(-1,1)
		research += fo.read(1)

	fo.read(1)
	# print(image)
	# print(name)
	# print(email)
	# print(edu)
	# print(phone)
	# print(research)

	user=''
	i=1
	while email[i] != '[':
		user += email[i]
		i+=1

	# print(user + '\n')

	image_loc = './CSE/images/'
	image = 'http://' + image
	# print image
	image_loc = image_loc + name + '.jpg'
	urllib.urlretrieve(image, image_loc)

	conn = sqlite3.connect('./CSE/cse.db')
	# print "Opened database successfully";

	conn.execute("INSERT INTO cse (NAME, USERNAME, EMAIL, EDUCATION, PHONE, RESEARCH, IMAGE) \
		VALUES (?, ?, ?, ?, ?, ?, ? )", (name, user, email, edu, phone, research, image_loc));
	conn.commit()
	conn.close()

	conn = sqlite3.connect('./CSE/cse.db')
	cursor = conn.execute("SELECT name, username, email, education, phone, research, image  from cse")
	for row in cursor:
	   print "Name = ", row[0]
	   print "Username = ", row[1]
	   print "Email = ", row[2]
	   print "Education = ", row[3]
	   print row[4]
	   print row[5]
	   print "Image =", row[6], "\n"

	# print "Operation done successfully";
	conn.close()
