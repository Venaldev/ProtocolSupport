package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_4_5_6;

import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.packet.ClientBoundPacket;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleSpawnLiving;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.typeremapper.id.IdRemapper;
import protocolsupport.protocol.typeremapper.legacy.LegacyDataWatcherSerializer;
import protocolsupport.protocol.typeremapper.skipper.id.IdSkipper;
import protocolsupport.protocol.typeremapper.watchedentity.WatchedDataRemapper;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableEmptyList;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

public class SpawnLiving extends MiddleSpawnLiving {

	@Override
	public RecyclableCollection<ClientBoundPacketData> toData(ProtocolVersion version) {
		if (IdSkipper.ENTITY.getTable(version).shouldSkip(entity.getType())) {
			return RecyclableEmptyList.get();
		}
		ClientBoundPacketData serializer = ClientBoundPacketData.create(ClientBoundPacket.PLAY_SPAWN_LIVING_ID, version);
		serializer.writeInt(entity.getId());
		serializer.writeByte(IdRemapper.ENTITY.getTable(version).getRemap(entity.getType()).getTypeId());
		serializer.writeInt((int) (x * 32));
		serializer.writeInt((int) (y * 32));
		serializer.writeInt((int) (z * 32));
		serializer.writeByte(yaw);
		serializer.writeByte(pitch);
		serializer.writeByte(headPitch);
		serializer.writeShort(motX);
		serializer.writeShort(motY);
		serializer.writeShort(motZ);
		LegacyDataWatcherSerializer.encodeData(serializer, version, cache.getLocale(), WatchedDataRemapper.transform(entity, metadata, version));
		return RecyclableSingletonList.create(serializer);
	}

}
