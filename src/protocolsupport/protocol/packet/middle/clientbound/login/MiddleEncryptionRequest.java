package protocolsupport.protocol.packet.middle.clientbound.login;

import java.io.IOException;

import protocolsupport.protocol.packet.middle.ClientBoundMiddlePacket;
import protocolsupport.protocol.serializer.PacketDataSerializer;

public abstract class MiddleEncryptionRequest<T> extends ClientBoundMiddlePacket<T> {

	protected String serverId;
	protected byte[] publicKey;
	protected byte[] verifyToken;

	@Override
	public void readFromServerData(PacketDataSerializer serializer) throws IOException {
		serverId = serializer.readString(Short.MAX_VALUE);
		publicKey = serializer.readArray();
		verifyToken = serializer.readArray();
	}

}
