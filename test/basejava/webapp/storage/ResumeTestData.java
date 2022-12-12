package basejava.webapp.storage;

import basejava.webapp.model.*;

import java.time.Month;
import java.util.Arrays;

public class ResumeTestData {
    public static void main(String args[]) {
        Resume R = new Resume("uuid", "Морозов Максим Владимирович");
        R.addContact(ContactType.PHONE, "+79229229292");
        R.addContact(ContactType.EMAIL, "plusmorozov@yandex.ru");
        R.addContact(ContactType.GITHUB, "https://github.com/plusmorozov");
        R.addSection(SectionType.PERSONAL, new TextSection("Section type is Personal"));
        R.addSection(SectionType.OBJECTIVE, new TextSection("Section type is Objective"));
        R.addSection(SectionType.ACHIEVEMENT, new ListSection(Arrays.asList("Item 1 in Achievement section", "Item 2 in Achievement section")));
        R.addSection(SectionType.QUALIFICATIONS, new ListSection(Arrays.asList("Item 1 in Qualifications section", "Item 2 in Qualifications section")));
        R.addSection(SectionType.EDUCATION,
                new OrganizationSection(Arrays.asList(
                        new Organization("University one", "http://universityone.ru",
                                Arrays.asList(
                                        new Period(2012, Month.JANUARY, 12, 2015, Month.JULY, 15, "Name of the first profession", "Description of the first profession"),
                                        new Period(2018, Month.MAY, 12, 2022, Month.APRIL, 15, "Name of the second profession", "Description of the second profession"))))));
        R.addSection(SectionType.EXPERIENCE,
                new OrganizationSection(Arrays.asList(
                        new Organization("Organization one", "http://organizationone.ru",
                                Arrays.asList(
                                        new Period(2016, Month.JANUARY, 12, 2015, Month.JULY, 15, "Name of the first position", "Description of the first position"))))));

        System.out.println(R.getContact(ContactType.PHONE));
        System.out.println(R.getContact(ContactType.EMAIL));
        System.out.println(R.getContact(ContactType.GITHUB));
        System.out.println(R.getSection(SectionType.PERSONAL));
        System.out.println(R.getSection(SectionType.OBJECTIVE));
        System.out.println(R.getSection(SectionType.ACHIEVEMENT));
        System.out.println(R.getSection(SectionType.QUALIFICATIONS));
        System.out.println(R.getSection(SectionType.EDUCATION).toString());
        System.out.println(R.getSection(SectionType.EXPERIENCE));
    }
}
