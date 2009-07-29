/* Poly2Tri
 * Copyright (c) 2009, Mason Green
 * http://code.google.com/p/poly2tri/
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * * Neither the name of Poly2Tri nor the names of its contributors may be
 *   used to endorse or promote products derived from this software without specific
 *   prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.poly2tri.shapes

case class Point(val x: Float, val y: Float) {
  
  // Pointers to next and previous points in Monontone Mountain
  var next, prev: Point = null
  // The setment this point belongs to
  var segment: Segment = null
  // Edge event pointer for CDT
  var eEvent: Segment = null
  // Point event pointer for CDT
  var pEvent: Segment = null
  
  @inline def -(p: Point) = Point(x - p.x, y - p.y) 
  @inline def +(p: Point) = Point(x + p.x, y + p.y)
  @inline def +(f: Float) = Point(x + f, y + f)
  @inline def -(f: Float) = Point(x - f, y - f)
  @inline def *(f: Float) = Point(x * f, y * f)
  @inline def /(a: Float) = Point(x / a, y / a)
  @inline def cross(p: Point) = x * p.y - y * p.x
  @inline def dot(p: Point) = x * p.x + y * p.y
  @inline def length = Math.sqrt(x * x + y * y).toFloat
  @inline def normalize = this / length  
  // Sort along x axis
  @inline def <(p: Point) = (x < p.x)
  // Sort along y axis
  @inline def >(p: Point) = (y < p.y) 
  @inline def !(p: Point) = !(p.x == x && p.y == y)
  @inline override def clone = Point(x, y)
}
