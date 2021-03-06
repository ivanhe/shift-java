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

import com.shapesecurity.functional.data.Either;
import com.shapesecurity.shift.ast.Expression;
import com.shapesecurity.shift.ast.Statement;
import com.shapesecurity.shift.ast.VariableDeclaration;
import com.shapesecurity.shift.ast.types.Type;

import org.jetbrains.annotations.NotNull;

public class ForInStatement extends IterationStatement {
  @NotNull
  public final Either<VariableDeclaration, Expression> left;
  @NotNull
  public final Expression right;

  public ForInStatement(
      @NotNull Either<VariableDeclaration, Expression> left,
      @NotNull Expression right,
      @NotNull Statement body) {
    super(body);
    this.left = left;
    this.right = right;
  }

  @NotNull
  @Override
  public Type type() {
    return Type.ForInStatement;
  }

  @Override
  public boolean equals(Object object) {
    return object instanceof ForInStatement &&
        this.left.equals(((ForInStatement) object).left) &&
        this.right.equals(((ForInStatement) object).right) &&
        this.body.equals(((ForInStatement) object).body);
  }

  @NotNull
  public Either<VariableDeclaration, Expression> getLeft() {
    return this.left;
  }

  @NotNull
  public Expression getRight() {
    return this.right;
  }

  @NotNull
  public ForInStatement setLeft(@NotNull Either<VariableDeclaration, Expression> left) {
    return new ForInStatement(left, this.right, this.body);
  }

  @NotNull
  public ForInStatement setRight(@NotNull Expression right) {
    return new ForInStatement(this.left, right, this.body);
  }

  @NotNull
  public ForInStatement setBody(@NotNull Statement body) {
    return new ForInStatement(this.left, this.right, body);
  }
}
