package com.kodluyoruz.stack;

import com.kodluyoruz.stack.exceptions.NoContentFound;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class StackTests {

    Stack<Integer> sut;

    @BeforeEach
    public void setup() {
        sut = new Stack<>();
    }

    @Test
    public void count_whenStackIsEmpty_shouldReturnItemCount() {
        //Arrange

        //Act
        int result = sut.count();

        //Assert
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void count_whenAddMultipleItems_shouldReturnItemNumber() {
        //Arrange

        //Ac2
        sut.push(1);
        sut.push(2);

        //Assert
        assertThat(sut.count()).isEqualTo(2);
    }

    @Test
    public void peek_whenItemPop_shouldRetrunCorrectSize() {
        //Arrange

        //Act
        sut.push(1);
        sut.pop();

        //Assert
        assertThat(sut.count()).isEqualTo(0);
    }

    @Test
    public void peek_whenItemPeek_shouldRetrunCorrectSize() {
        //Arrange

        //Act
        sut.push(1);
        sut.peek();

        //Assert
        assertThat(sut.count()).isEqualTo(1);
    }

    @Test
    public void push_shouldAddItem() {
        //Arrange

        //Act
        sut.push(1);

        //Assert
        assertThat(sut.count()).isEqualTo(1);
    }

    @Test
    public void push_whenItemIsNull_shouldGiveIllegalArgumentException() {
        //Arrange

        //Act
        Throwable throwable = catchThrowable(() -> sut.push(null));

        //Assert
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class).hasMessage("Item can not be null!");
    }

    @Test
    public void pop_whenStackIsEmpty_shouldGiveIllegalArgumentException() {
        //Arrange

        //Act
        Throwable throwable = catchThrowable(() -> sut.pop());

        //Assert
        assertThat(throwable).isInstanceOf(NoContentFound.class).hasMessage("Stack is empty!");
    }

    @Test
    public void pop_whenItemDeleted_shouldPopItem() {
        //Arrange

        //Act
        sut.push(1);
        Integer result = sut.pop();

        //Assert
        assertThat(result).isEqualTo(1);
        assertThat(sut.count()).isEqualTo(0);
    }

    @Test
    public void peek_whenStackIsEmpty_shouldGiveIllegalArgumentException() {
        //Arrange

        //Act
        Throwable throwable = catchThrowable(() -> sut.peek());

        //Assert
        assertThat(throwable).isInstanceOf(NoContentFound.class).hasMessage("Stack is empty!");
    }

    @Test
    public void peek_shouldPickItem() {
        //Arrange

        //Act
        sut.push(1);
        Integer result = sut.peek();

        //Assert
        assertThat(result).isEqualTo(1);
        assertThat(sut.count()).isEqualTo(1);
    }
}
