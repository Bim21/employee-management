package com.ncc.specification;

import com.ncc.entity.Employee;
import com.ncc.entity.Role;
import com.ncc.form.EmployeeFilterForm;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification {
    public static Specification<Employee> buildWhere(EmployeeFilterForm form){
        if(form == null){
            return null;
        }
        return hasFirstNameLike(form.getSearch()).or(hasLastNameLike(form.getSearch()));

    }

    public static Specification<Employee> hasFirstNameLike(String value){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("firstName")), "%" + value.toLowerCase() + "%"));
    }

    public static Specification<Employee> hasLastNameLike(String value){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("lastName")), "%" + value.toLowerCase() + "%"));
    }

}
