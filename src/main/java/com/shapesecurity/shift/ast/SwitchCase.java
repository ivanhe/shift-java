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

package com.shapesecurity.shift.ast;

import com.shapesecurity.functional.data.ImmutableList;
import com.shapesecurity.shift.ast.types.Type;

import org.jetbrains.annotations.NotNull;

public class SwitchCase extends Node {
  @NotNull
  public final Expression test;
  @NotNull
  public final ImmutableList<Statement> consequent;

  public SwitchCase(@NotNull Expression test, @NotNull ImmutableList<Statement> consequent) {
    super();
    this.test = test;
    this.consequent = consequent;
  }

  @NotNull
  @Override
  public Type type() {
    return Type.SwitchCase;
  }

  @Override
  public boolean equals(Object object) {
    return object instanceof SwitchCase && this.test.equals(((SwitchCase) object).test) && this.consequent.equals(
        ((SwitchCase) object).consequent);
  }

  @NotNull
  public Expression getTest() {
    return this.test;
  }

  @NotNull
  public ImmutableList<Statement> getConsequent() {
    return this.consequent;
  }

  @NotNull
  public SwitchCase setTest(@NotNull Expression test) {
    return new SwitchCase(test, this.consequent);
  }

  @NotNull
  public SwitchCase setConsequent(@NotNull ImmutableList<Statement> consequent) {
    return new SwitchCase(this.test, consequent);
  }
}
