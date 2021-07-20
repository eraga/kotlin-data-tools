package net.eraga.tools.models

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Id
import kotlin.Comparable

/**
 * **Test2**
 *
 * TODO: Test2 description
 *
 * @author
 *  [Klaus Schwartz](mailto:klaus@eraga.net)
 *
 *  Developed at [eRaga InfoSystems](https://www.eraga.net/)
 *
 *  Date: 18/07/2021
 *  Time: 21:13
 */
interface WithAnyID {
    val id: Any
}

interface WithIntID : WithAnyID {
    override val id: Int
}

interface WithName {
    val name: String
}

interface WithSecondName {
    val secondName: String
}

interface WithIdAndName : WithIntID, WithName

@Implement.Immutable
@Implement.DTO
@Implement.DTO(suffix = "Update", propsForceNull = true)
interface PersonModel :
        WithIntID,
        WithName,
        WithSecondName,
        WithIdAndName,
        Comparable<PersonModel>,
        Cloneable,
        Serializable {

//    @Deprecated("Test")
//    @get:Id
    @ConstructorInitializer("42")
//    @Implement.Omit
//    @Implement.Omit("PersonUpdateDTO")
//    @Implement.Omit("PersonDTO")
    override var id: Int

    @Implement.DTO
    private class UpdateIdNameRequest() : WithIdAndName {

//        @Implement.Omit("PersonUpdateIdNameRequestDTO")
//        @Implement.Omit
        @ConstructorInitializer("42")
        override val id: Int = 0
        @ConstructorInitializer("\"42\"")
        override val name: String = ""
    }

//    fun deepClone(): PersonModel
}


@Implement.JPAEntity
interface PersonJPAModel : PersonModel {
    override var id: Int
    override val name: String
    override val secondName: String
}

fun main() {
    println("done")

    val person = PersonDTO()
}