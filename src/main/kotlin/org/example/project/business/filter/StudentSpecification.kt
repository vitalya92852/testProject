package org.example.project.business.filter


import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root
import org.example.project.business.filter.dto.FilterDto
import org.example.project.dal.POJO.CityPOJO
import org.example.project.dal.model.Student
import org.springframework.data.jpa.domain.Specification
import java.time.LocalDate

class StudentSpecification{
    companion object {
        fun getSpecification(filterDto: FilterDto): Specification<Student> {
            return Specification { root: Root<Student>, query, criteriaBuilder: CriteriaBuilder ->
                val predicates = mutableListOf<Predicate>()
                filterDto.name?.let {
                    predicates.add(criteriaBuilder.like(root.get("name"), it))
                }
                filterDto.lastname?.let {
                    predicates.add(criteriaBuilder.like(root.get("lastname"), it))
                }
                filterDto.typeOfStudent?.let {
                    predicates.add(criteriaBuilder.like(root.get("type_of_student"), it))
                }
                filterDto.birthDay?.let {
                    predicates.add(criteriaBuilder.equal(root.get<LocalDate>("birth_day"), it))
                }
//                filterDto.city?.let {
//                    predicates.add(criteriaBuilder.equal(root.get<LocalDate>("city"), it))
//                }
//                filterDto.city?.let {
//                    predicates.add(criteriaBuilder.like(root.get("city"),it))
//                }
//                filterDto.country?.let {
//                    predicates.add(criteriaBuilder.like(root.get("country"),it))
//                }

                 criteriaBuilder.and(*predicates.toTypedArray())
            }
        }
    }

}