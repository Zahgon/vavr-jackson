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

import io.vavr.control.Either;
import tools.jackson.core.JsonParser;
import tools.jackson.core.JsonToken;
import tools.jackson.databind.DatabindException;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JavaType;
import tools.jackson.databind.ValueDeserializer;
import static tools.jackson.core.JsonToken.END_ARRAY;
import static tools.jackson.core.JsonToken.END_OBJECT;
import static tools.jackson.core.JsonToken.START_ARRAY;
import static tools.jackson.core.JsonToken.START_OBJECT;
import static tools.jackson.core.JsonToken.VALUE_NULL;

class EitherDeserializer extends VavrValueDeserializer<Either<?, ?>> {

    private final JavaType javaType;

    private volatile ValueDeserializer<?> stringDeserializer;

    EitherDeserializer(JavaType valueType) {
        super(valueType, 2);
        this.javaType = valueType;
    }

    @Override
    public Either<?, ?> deserialize(JsonParser p, DeserializationContext ctxt) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void resolve(DeserializationContext ctxt) throws DatabindException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static boolean isRight(final String fieldName) {
        return "right".equals(fieldName) || "r".equals(fieldName);
    }

    private static boolean isLeft(final String fieldName) {
        return "left".equals(fieldName) || "l".equals(fieldName);
    }

    private Object parseObject(JsonParser p, DeserializationContext ctxt, int index) {
        final ValueDeserializer<?> deserializer = deserializer(index);
        final Object value = p.nextToken() != VALUE_NULL ? deserializer.deserialize(p, ctxt) : deserializer.getNullValue(ctxt);
        if (p.nextToken() != END_OBJECT) {
            throw mappingException(ctxt, javaType.getRawClass(), p.currentToken());
        }
        return value;
    }
}
