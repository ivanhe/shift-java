/*
 * Copyright 2014 Shape Security, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.shapesecurity.shift.ast.statement;

import com.shapesecurity.shift.ast.Expression;
import com.shapesecurity.shift.ast.Statement;
import com.shapesecurity.shift.ast.types.Type;

import org.jetbrains.annotations.NotNull;

public class WhileStatement extends IterationStatement {
  @NotNull
  public final Expression test;

  public WhileStatement(@NotNull Expression test, @NotNull Statement body) {
    super(body);
    this.test = test;
  }

  @NotNull
  @Override
  public Type type() {
    return Type.WhileStatement;
  }

  @Override
  public boolean equals(Object object) {
    return object instanceof WhileStatement && this.test.equals(((WhileStatement) object).test) &&
        this.body.equals(((WhileStatement) object).body);
  }

  @NotNull
  public Expression getTest() {
    return this.test;
  }

  @NotNull
  public WhileStatement setTest(@NotNull Expression test) {
    return new WhileStatement(test, this.body);
  }

  @NotNull
  public WhileStatement setBody(@NotNull Statement body) {
    return new WhileStatement(this.test, body);
  }
}
