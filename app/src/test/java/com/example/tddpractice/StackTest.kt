package com.example.tddpractice

import junit.framework.TestCase.assertEquals
import org.junit.Test

/**
 * Created by Artem Skorik email(artem.newage@outlook.com) on 20.01.2023.
 */
class StackTest {

    @Test(expected = IllegalStateException::class)
    fun `invalid object negative count`() {
        CustomStack.Base<CustomObject>(maxCount = -1)
    }

    @Test(expected = IllegalStateException::class)
    fun `invalid object zero count`() {
        CustomStack.Base<CustomObject>(maxCount = 0)
    }

    @Test(expected = IllegalStateException::class)
    fun `pop item from empty stack`() {
        val stack = CustomStack.Base<CustomObject>(maxCount = 1)
        stack.pop()
    }

    @Test(expected = IllegalStateException::class)
    fun `pop more then pushed`() {
        val stack = CustomStack.Base<CustomObject>(maxCount = 1)
        stack.push(item = CustomObject("0"))
        stack.pop()
        stack.pop()
    }

    @Test
    fun `push more items then max count`() {
        val stack = CustomStack.Base<CustomObject>(maxCount = 1)
        stack.push(item = CustomObject("0"))
        try {
            stack.push(item = CustomObject("1"))
        } catch (e: Exception) {
            assertEquals(true, e is IllegalStateException)
            assertEquals("Stack overflow exception, maximum is 1", e.message)
        }
    }

    @Test
    fun pop() {
        val stack = CustomStack.Base<CustomObject>(maxCount = 1)
        stack.push(item = CustomObject("0"))
        val expected = CustomObject("0")
        val actual = stack.pop()
        assertEquals(expected, actual)
    }

    @Test
    fun push() {
        val stack = CustomStack.Base<CustomObject>(maxCount = 2)
        stack.push(0)
        stack.push(1)
        assertEquals(1, stack[0])
        assertEquals(0, stack[1])
    }
}

private data class CustomObject(val id: String)