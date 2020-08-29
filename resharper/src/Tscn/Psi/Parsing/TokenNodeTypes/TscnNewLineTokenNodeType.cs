using JetBrains.ReSharper.Psi;
using JetBrains.ReSharper.Psi.ExtensionsAPI.Tree;
using JetBrains.Text;

namespace JetBrains.ReSharper.Plugins.Godot.Tscn.Psi.Parsing.TokenNodeTypes
{
    internal class TscnNewLineTokenNodeType : TscnTokenNodeTypeBase
    {
        public TscnNewLineTokenNodeType(int index) : base("NEW_LINE", index)
        {
        }

        public override LeafElementBase Create(IBuffer buffer, TreeOffset startOffset, TreeOffset endOffset)
        {
            throw new System.NotImplementedException();
        }

        public override bool IsWhitespace => true;
        public override string TokenRepresentation => @"\r\n";
    }
}