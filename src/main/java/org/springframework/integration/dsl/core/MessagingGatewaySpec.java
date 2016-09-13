/*
 * Copyright 2014-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.dsl.core;

import org.springframework.integration.gateway.MessagingGatewaySupport;
import org.springframework.integration.mapping.InboundMessageMapper;
import org.springframework.integration.mapping.OutboundMessageMapper;
import org.springframework.messaging.MessageChannel;

/**
 * An {@link IntegrationComponentSpec} for {@link MessagingGatewaySupport}s.
 *
 * @param <S> the target {@link MessagingGatewaySpec} implementation type.
 * @param <G> the target {@link MessagingGatewaySupport} implementation type.
 *
 * @author Artem Bilan
 */
public abstract class MessagingGatewaySpec<S extends MessagingGatewaySpec<S, G>, G extends MessagingGatewaySupport>
		extends IntegrationComponentSpec<S, G> {

	public MessagingGatewaySpec(G gateway) {
		this.target = gateway;
	}

	@Override
	public S id(String id) {
		this.target.setBeanName(id);
		return super.id(id);
	}

	/**
	 * A lifecycle phase to use.
	 * @param phase the phase.
	 * @return the spec.
	 * @see org.springframework.context.SmartLifecycle
	 */
	public S phase(int phase) {
		this.target.setPhase(phase);
		return _this();
	}

	/**
	 * An auto-startup flag.
	 * @param autoStartup the autoStartup.
	 * @return the spec.
	 * @see org.springframework.context.SmartLifecycle
	 */
	public S autoStartup(boolean autoStartup) {
		this.target.setAutoStartup(autoStartup);
		return _this();
	}

	/**
	 * A reply channel to use.
	 * @param replyChannel the replyChannel.
	 * @return the spec.
	 * @see MessagingGatewaySupport#setReplyChannel(MessageChannel)
	 */
	public S replyChannel(MessageChannel replyChannel) {
		this.target.setReplyChannel(replyChannel);
		return _this();
	}

	/**
	 * A reply channel name to use.
	 * @param replyChannelName the name of replyChannel.
	 * @return the spec.
	 * @since 1.1.1
	 * @see MessagingGatewaySupport#setReplyChannelName(String)
	 */
	public S replyChannel(String replyChannelName) {
		this.target.setReplyChannelName(replyChannelName);
		return _this();
	}

	/**
	 * A request channel to use.
	 * @param requestChannel the requestChannel.
	 * @return the spec.
	 * @see MessagingGatewaySupport#setRequestChannel(MessageChannel)
	 */
	public S requestChannel(MessageChannel requestChannel) {
		this.target.setRequestChannel(requestChannel);
		return _this();
	}

	/**
	 * A request channel name to use.
	 * @param requestChannelName the name of requestChannel.
	 * @return the spec.
	 * @since 1.1.1
	 * @see MessagingGatewaySupport#setRequestChannelName(String)
	 */
	public S requestChannel(String requestChannelName) {
		this.target.setRequestChannelName(requestChannelName);
		return _this();
	}

	/**
	 * An error channel to use.
	 * @param errorChannel the errorChannel.
	 * @return the spec.
	 * @see MessagingGatewaySupport#setErrorChannel(MessageChannel)
	 */
	public S errorChannel(MessageChannel errorChannel) {
		this.target.setErrorChannel(errorChannel);
		return _this();
	}

	/**
	 * An error channel name to use.
	 * @param errorChannelName the name of errorChannel.
	 * @return the spec.
	 * @since 1.1.1
	 * @see MessagingGatewaySupport#setErrorChannelName(String)
	 */
	public S errorChannel(String errorChannelName) {
		this.target.setErrorChannelName(errorChannelName);
		return _this();
	}

	/**
	 * A request timeout to use.
	 * @param requestTimeout the requestTimeout.
	 * @return the spec.
	 * @see MessagingGatewaySupport#setRequestTimeout(long)
	 */
	public S requestTimeout(long requestTimeout) {
		this.target.setRequestTimeout(requestTimeout);
		return _this();
	}

	/**
	 * A reply timeout to use.
	 * @param replyTimeout the replyTimeout.
	 * @return the spec.
	 * @see MessagingGatewaySupport#setReplyTimeout(long)
	 */
	public S replyTimeout(long replyTimeout) {
		this.target.setReplyTimeout(replyTimeout);
		return _this();
	}

	/**
	 * An {@link InboundMessageMapper} to use.
	 * @param requestMapper the requestMapper.
	 * @return the spec.
	 * @see MessagingGatewaySupport#setRequestMapper(InboundMessageMapper)
	 */
	public S requestMapper(InboundMessageMapper<?> requestMapper) {
		this.target.setRequestMapper(requestMapper);
		return _this();
	}

	/**
	 * An {@link OutboundMessageMapper} to use.
	 * @param replyMapper the replyMapper.
	 * @return the spec.
	 * @see MessagingGatewaySupport#setReplyMapper(OutboundMessageMapper)
	 */
	public S replyMapper(OutboundMessageMapper<?> replyMapper) {
		this.target.setReplyMapper(replyMapper);
		return _this();
	}

}
