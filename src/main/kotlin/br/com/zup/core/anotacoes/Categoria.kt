package br.com.zup.core.anotacoes

import io.micronaut.core.annotation.AnnotationValue
import io.micronaut.validation.validator.constraints.ConstraintValidator
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext
import javax.inject.Singleton
import javax.validation.Constraint
import kotlin.annotation.AnnotationRetention.*
import kotlin.annotation.AnnotationTarget.*

@MustBeDocumented
@Target(FIELD, CONSTRUCTOR)
@Retention(RUNTIME)
@Constraint(validatedBy = [CategoriaValidator::class])
annotation class Categoria(val message: String = "Categoria não existe")

@Singleton
class CategoriaValidator : ConstraintValidator<Categoria, String> {

    override fun isValid(
        value: String?,
        annotationMetadata: AnnotationValue<Categoria>,
        context: ConstraintValidatorContext
    ): Boolean {
        val categorias = arrayOf("Liderança", "Cultura", "Filosofia", "Estratégia")

        return categorias.contains(value)
    }

}
