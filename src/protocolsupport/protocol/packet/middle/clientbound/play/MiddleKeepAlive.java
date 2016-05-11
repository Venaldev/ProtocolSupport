package protocolsupport.protocol.packet.middle.clientbound.play;

import protocolsupport.protocol.packet.middle.ClientBoundMiddlePacket;
import protocolsupport.protocol.serializer.PacketDataSerializer;

public abstract class MiddleKeepAlive<T> extends ClientBoundMiddlePacket<T> {

	protected int keepAliveId;

	@Override
	public void readFromServerData(PacketDataSerializer serializer) {
		keepAliveId = serializer.readVarInt();
	}

}
