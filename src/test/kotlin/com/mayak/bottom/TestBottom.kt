/*
The MIT License (MIT)

Copyright (c) 2021-present Maya Kemp

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

package com.mayak.bottom

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TestBottom {
    @Test
    fun testStringEncode() {
        assertEquals(
            "\uD83D\uDC96✨✨✨,,,,\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96,\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96✨\uD83E\uDD7A\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96✨\uD83E\uDD7A,\uD83D\uDC49\uD83D\uDC48",
            Bottom.encodeString("Test")
        )
    }

    @Test
    fun testByteEncode() {
        assertEquals(
            "\uD83D\uDC96\uD83D\uDC96,,,,\uD83D\uDC49\uD83D\uDC48",
            Bottom.encodeByte("h".toUByteArray()[0])
        )
    }

    @Test
    fun testCharDecode() {
        assertEquals(
            "h".codePointAt(0).toUByte(),
            Bottom.decodeByte("\uD83D\uDC96\uD83D\uDC96,,,,")
        )
    }

    @Test
    fun testStringDecode() {
        assertEquals(
            "Test",
            Bottom.decodeString("\uD83D\uDC96✨✨✨,,,,\u200B\uD83D\uDC96\uD83D\uDC96,\u200B\uD83D\uDC96\uD83D\uDC96✨\uD83E\uDD7A\u200B\uD83D\uDC96\uD83D\uDC96✨\uD83E\uDD7A,\u200B")
        )
        assertEquals(
            "Test",
            Bottom.decodeString("\uD83D\uDC96✨✨✨,,,,\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96,\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96✨\uD83E\uDD7A\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96✨\uD83E\uDD7A,\uD83D\uDC49\uD83D\uDC48")
        )
    }

    @Test
    fun testUnicodeStringEncode() {
        assertEquals(
            "\uD83E\uDEC2✨✨✨✨\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96\uD83D\uDC96\uD83E\uDD7A,,,,\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96\uD83D\uDC96✨\uD83E\uDD7A\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96\uD83D\uDC96✨✨✨\uD83E\uDD7A,\uD83D\uDC49\uD83D\uDC48",
            Bottom.encodeString("\uD83E\uDD7A")
        )
        assertEquals(
            "\uD83E\uDEC2✨✨\uD83E\uDD7A,,\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96✨✨\uD83E\uDD7A,,,,\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96✨✨✨✨\uD83D\uDC49\uD83D\uDC48\uD83E\uDEC2✨✨\uD83E\uDD7A,,\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96✨✨✨\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96✨✨✨✨\uD83E\uDD7A,,\uD83D\uDC49\uD83D\uDC48\uD83E\uDEC2✨✨\uD83E\uDD7A,,\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96✨✨\uD83E\uDD7A,,,,\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96\uD83D\uDC96✨✨\uD83E\uDD7A,\uD83D\uDC49\uD83D\uDC48\uD83E\uDEC2✨✨\uD83E\uDD7A,,\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96✨✨✨\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96✨✨✨✨\uD83D\uDC49\uD83D\uDC48",
            Bottom.encodeString("がんばれ")
        )
    }

    @Test
    fun testUnicodeStringDecode() {
        assertEquals(
            "\uD83E\uDD7A",
            Bottom.decodeString("\uD83E\uDEC2✨✨✨✨\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96\uD83D\uDC96\uD83E\uDD7A,,,,\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96\uD83D\uDC96✨\uD83E\uDD7A\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96\uD83D\uDC96✨✨✨\uD83E\uDD7A,\uD83D\uDC49\uD83D\uDC48")
        )
        assertEquals(
            "がんばれ",
            Bottom.decodeString("\uD83E\uDEC2✨✨\uD83E\uDD7A,,\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96✨✨\uD83E\uDD7A,,,,\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96✨✨✨✨\uD83D\uDC49\uD83D\uDC48\uD83E\uDEC2✨✨\uD83E\uDD7A,,\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96✨✨✨\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96✨✨✨✨\uD83E\uDD7A,,\uD83D\uDC49\uD83D\uDC48\uD83E\uDEC2✨✨\uD83E\uDD7A,,\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96✨✨\uD83E\uDD7A,,,,\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96\uD83D\uDC96✨✨\uD83E\uDD7A,\uD83D\uDC49\uD83D\uDC48\uD83E\uDEC2✨✨\uD83E\uDD7A,,\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96✨✨✨\uD83D\uDC49\uD83D\uDC48\uD83D\uDC96\uD83D\uDC96✨✨✨✨\uD83D\uDC49\uD83D\uDC48")
        )
    }
}