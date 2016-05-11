package protocolsupport.protocol.packet.middle.clientbound.play;

import java.io.IOException;

import protocolsupport.protocol.serializer.PacketDataSerializer;

public abstract class MiddleBlockBreakAnimation<T> extends MiddleBlock<T> {

	protected int entityId;
	protected int stage;

	@Override
	public void readFromServerData(PacketDataSerializer serializer) throws IOException {
		entityId = serializer.readVarInt();
		super.readFromServerData(serializer);
		stage = serializer.readByte();
	}

}
