# addressbook

Easy addressbook with Java 8

# Features

1. How many males are in the address book?
To solve this I have used Java 8 streams to traverse all data; using a filter.
Can be used to Males and Females

2. Who is the oldest person in the address book?
I´ve used the same approach, but using min.

3. How many days older is Bill than Paul?
JodaTime is the perfect library to do this. It´s implemented in Person class because it a comparison between two objects
of that class.
Test: AddressBookServiceImplTest#howOlderIsBillThanPaul



# Notes
 1. For days between dates I´ve used JodaTime, it is suitable for this purpose and I feel comfortable with it.
 2. I´ve used Java 8 stream although I am not very familiar with it. From my perspective the the easiest way to manage
 data from a stream.
 3. If there is any parsing data problem there are default values. Male for gender and "today" for dob.
 4. In the addressbook I've added a reload to be able to add data to the addressbook.