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


package com.shapesecurity.shift.ast.types;

import org.jetbrains.annotations.NotNull;

public class NonEmptyListType implements GenType {
  public static final NonEmptyListType VARIABLE_DECLARATOR = new NonEmptyListType(Type.VariableDeclarator);

  @NotNull
  public final GenType elementType;

  private NonEmptyListType(@NotNull GenType elementType) {
    this.elementType = elementType;
  }

  @NotNull
  @Override
  public Type rawType() {
    return Type.NonEmptyList;
  }

  @Override
  public boolean isAssignableFrom(@NotNull GenType type) {
    return type == this ||
           (type instanceof NonEmptyListType && this.elementType.isAssignableFrom(((NonEmptyListType) type).elementType));
  }

  @NotNull
  public static NonEmptyListType from(@NotNull GenType elementType) {
    if (elementType == Type.VariableDeclarator) {
      return VARIABLE_DECLARATOR;
    }
    return new NonEmptyListType(elementType);
  }
}
