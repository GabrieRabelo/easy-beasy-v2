package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.domain.Question;
import com.thoughtworks.aceleradora.repository.QuestionRepository;
import com.thoughtworks.aceleradora.service.QuestionService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class QuestionServiceTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionService questionService;

    @Test
    public void shouldReturnOKIfISaveAValidQuestion() {
        Question expectedQuestion = new Question( "Sei lá?");

        Mockito.when(questionRepository.salvar(expectedQuestion)).thenReturn(Arrays.asList(expectedQuestion));

        List<Question> questions = questionService.salvar(expectedQuestion);

        Question questionResult = questions.get(0);
        Assert.assertEquals(expectedQuestion.getPriority(), questionResult.getPriority());
        Assert.assertEquals(expectedQuestion.getDescription(), questionResult.getDescription());

    }

}
