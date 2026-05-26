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
package io.vavr.jackson.datatype.serialize;

import io.vavr.control.Either;
import io.vavr.control.Option;
import tools.jackson.core.JsonGenerator;
import tools.jackson.core.exc.StreamWriteException;
import tools.jackson.databind.*;
import tools.jackson.databind.ValueSerializer;
import tools.jackson.databind.ser.bean.BeanSerializerBase;
import tools.jackson.databind.ser.std.StdSerializer;
import tools.jackson.databind.util.NameTransformer;

/**
 * A Jackson serializer for {@link Option} that supports unwrapping its contained value when the
 * property is annotated with {@code @JsonUnwrapped}.
 * <p>
 * If the {@link Option} is defined, its value is serialized directly using an internal
 * {@link NameTransformer} to handle field unwrapping. If the {@link Option} is empty, {@code null}
 * is written.
 * </p>
 * <p>
 * Only bean-like values can be unwrapped. Other Vavr types, such as {@link io.vavr.control.Try} or
 * {@link Either}, are not supported because {@link com.fasterxml.jackson.annotation.JsonUnwrapped}
 * only applies to Java beans.
 * </p>
 * <p>
 * Unwrapping is delegated to a {@link BeanSerializerBase} via a {@link NameTransformer}, since
 * unwrapping requires serializing fields individually rather than the entire object.
 * </p>
 */
class UnwrappingOptionSerializer extends StdSerializer<Option<?>> {

    private final OptionSerializer optionSerializer;

    private final NameTransformer unwrapper;

    public UnwrappingOptionSerializer(OptionSerializer optionSerializer, NameTransformer unwrapper) {
        super(optionSerializer.getValueType());
        this.optionSerializer = optionSerializer;
        this.unwrapper = unwrapper;
    }

    /**
     * Try to serialize the option value.
     * Writes null if the value is not defined.
     *
     * @param value Value to serialize; can <b>not</b> be null.
     * @param gen Generator used to output resulting Json content
     * @param context Provider that can be used to get serializers for serializing Objects value contains, if any.
     * @throws StreamWriteException if the option value is not a bean
     */
    @Override
    public void serialize(Option<?> value, JsonGenerator gen, SerializationContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isUnwrappingSerializer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isEmpty(SerializationContext context, Option<?> value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ValueSerializer<?> createContextual(SerializationContext context, BeanProperty property) throws DatabindException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
