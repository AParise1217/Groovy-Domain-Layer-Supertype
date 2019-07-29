package com.parisesoftware.domain

import com.parisesoftware.archetype.person.FirstName
import com.parisesoftware.archetype.person.LastName
import com.parisesoftware.archetype.person.Person
import com.parisesoftware.archetype.person.PersonName
import com.parisesoftware.archetype.user.User
import com.parisesoftware.archetype.user.UserIdentifier
import spock.lang.Specification

class UsersTest extends Specification {

    def "getFirstNames: Should Return all User's First Names"() {

        given: "a few sample Users"
            def testFirstName1 = FirstName.of('Johnny'.toLowerCase())
            def testFirstName2 = FirstName.of('Eric'.toLowerCase())

            def testUser1 = User.of(
                    UserIdentifier.of('a1111'),
                    Person.of(PersonName.of(testFirstName1, LastName.of('Cade')))
            )

            def testUser2 = User.of(
                    UserIdentifier.of('b2222'),
                    Person.of(PersonName.of(testFirstName1, LastName.of('Depp')))
            )

            def testUser3 = User.of(
                    UserIdentifier.of('c3333'),
                    Person.of(PersonName.of(testFirstName1, LastName.of('Appleseed')))
            )

            def testUser4 = User.of(
                    UserIdentifier.of('d4444'),
                    Person.of(PersonName.of(testFirstName2, LastName.of('Clapton')))
            )

            def testUserList = [testUser1, testUser2, testUser3, testUser4]

        when: "we create a new Domain based off our sample Users"
            Users testUsers = new Users(testUserList)

        and: "we invoke the find domains method"
            def resultant = testUsers.firstNames

        then: "the resultant map is not null"
            resultant != null

        and: "the resultant map contains three entries for our first domain"
            resultant.containsKey(testFirstName1)
            Objects.equals(resultant.get(testFirstName1), 3)

        and: "the resultant map contains one entry for our second domain"
            resultant.containsKey(testFirstName2)
            Objects.equals(resultant.get(testFirstName2), 1)
    }

}
