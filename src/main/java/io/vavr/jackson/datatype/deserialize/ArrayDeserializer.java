/*  __    __  __  __    __  ___
 * \  \  /  /    \  \  /  /  __/
 *  \  \/  /  /\  \  \/  /  /
 *   \____/__/  \__\____/__/
 *
 * Copyright 2014-2025 Vavr, http://vavr.io
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
package io.vavr.jackson.datatype.deserialize;

import io.vavr.collection.Traversable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tools.jackson.core.JsonParser;
import tools.jackson.core.JsonToken;
import tools.jackson.databind.BeanProperty;
import tools.jackson.databind.DatabindException;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JavaType;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.jsontype.TypeDeserializer;
import static tools.jackson.core.JsonToken.END_ARRAY;
import static tools.jackson.core.JsonToken.VALUE_NULL;

abstract class ArrayDeserializer<T> extends VavrValueDeserializer<T> {

    protected final JavaType collectionType;

    protected final JavaType elementType;

    protected final TypeDeserializer elementTypeDeserializer;

    protected final ValueDeserializer<?> elementDeserializer;

    protected final boolean deserializeNullAsEmptyCollection;

    ArrayDeserializer(JavaType collectionType, int typeCount, JavaType elementType, TypeDeserializer elementTypeDeserializer, ValueDeserializer<?> elementDeserializer, boolean deserializeNullAsEmptyCollection) {
        super(collectionType, typeCount);
        this.collectionType = collectionType;
        this.elementType = elementType;
        this.elementTypeDeserializer = elementTypeDeserializer;
        this.elementDeserializer = elementDeserializer;
        this.deserializeNullAsEmptyCollection = deserializeNullAsEmptyCollection;
    }

    abstract T create(List<Object> list, DeserializationContext ctxt) throws DatabindException;

    /**
     * Creates a new deserializer from the original one (this).
     *
     * @param elementTypeDeserializer the new deserializer for the element type
     * @param elementDeserializer     the new deserializer for the element itself
     *
     * @return a new deserializer
     */
    abstract ArrayDeserializer<T> createDeserializer(TypeDeserializer elementTypeDeserializer, ValueDeserializer<?> elementDeserializer);

    @Override
    public ValueDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws DatabindException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public T deserialize(JsonParser parser, DeserializationContext context, T intoValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public T deserialize(JsonParser parser, DeserializationContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public T getNullValue(DeserializationContext ctxt) throws DatabindException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static void checkContainedTypeIsComparable(DeserializationContext ctxt, JavaType type) throws DatabindException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
